package com.raqsoft.expression.operator;

import com.raqsoft.resources.EngineMessage;
import com.raqsoft.expression.Operator;
import com.raqsoft.common.MessageManager;
import com.raqsoft.common.RQException;
import com.raqsoft.dm.Context;
import com.raqsoft.dm.Sequence;
import com.raqsoft.util.CursorUtil;
import com.raqsoft.util.Variant;

/**
 * 运算符：%
 * 取余或序列异或
 * @author RunQian
 *
 */
public class Mod extends Operator {
	public Mod() {
		priority = PRI_MOD;
	}

	public Object calculate(Context ctx) {
		if (left == null) {
			MessageManager mm = EngineMessage.get();
			throw new RQException("\"%\"" + mm.getMessage("operator.missingLeftOperation"));
		}
		
		if (right == null) {
			MessageManager mm = EngineMessage.get();
			throw new RQException("\"%\"" + mm.getMessage("operator.missingRightOperation"));
		}

		Object o1 = left.calculate(ctx);
		Object o2 = right.calculate(ctx);

		//如果有序列，就是XOR计算
		if (o1 instanceof Sequence || o2 instanceof Sequence) {
			Sequence seq1, seq2;
			if (!(o1 instanceof Sequence)) {
				seq1 = new Sequence(1);
				seq1.add(o1);
				seq2 = (Sequence) o2;
			} else if (!(o2 instanceof Sequence)) {
				seq2 = new Sequence(1);
				seq2.add(o2);
				seq1 = (Sequence) o1;
			} else {
				seq1 = (Sequence) o1;
				seq2 = (Sequence) o2;
			}
			
			return CursorUtil.xor(seq1, seq2);
		}
		
		return Variant.mod(o1, o2);
	}
}
