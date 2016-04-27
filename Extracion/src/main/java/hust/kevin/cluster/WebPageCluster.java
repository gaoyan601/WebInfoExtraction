package hust.kevin.cluster;

import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.model.Page;

public abstract class WebPageCluster extends Cluster<Page> {

	@Override
	public float simCaculate(Page p1, Page p2) {
		// TODO Auto-generated method stub
		Element e1 = p1.getDoc().getElementsByTag("body").get(0);
		Element e2 = p2.getDoc().getElementsByTag("body").get(0);
		return compareElement(e1, e2, 0);
	}

	@Override
	public List<List<Page>> getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	private static float compareElement(Element e1, Element e2, int Level) {
		if (Level < 0 || e1 == null || e2 == null) {
			return 0;
		}
		/**
		 * 判断两个标签的tag和attributes是否相同,如果不相同，则判断两个element不相同，返回0
		 */
		if (!e1.tagName().equals(e2.tagName())
				|| !e1.ownText().equals(e2.ownText())) {
			return 0;
		}

		Elements es1 = e1.children();
		Elements es2 = e2.children();
		int length1 = es1.size();
		int length2 = es2.size();

		/**
		 * 判断两个节点的孩子节点的个数是否相同，不相同返回0 如果相同且等于0，返回1 否则，继续
		 */
		if (length1 != length2) {
			return 0;
		}
		if (length1 == 0) {
			return 1;
		}

		/**
		 * 初始化Lp
		 */
		float[] Lp = new float[length1];
		if (Level == 0) {
			float amount = 0;
			for (int i = 0; i < length1; i++) {
				amount += Math.abs((float) (length1 - 1) / 2 - i) + 1;
			}
			for (int i = 0; i < length1; i++) {
				Lp[i] = (Math.abs((float) (length1 - 1) / 2 - i) + 1) / amount;
			}
		} else {
			float temp = (float) 1 / length1;
			for (int i = 0; i < length1; i++) {
				Lp[i] = temp;
			}
		}

		float sum = 0f;
		for (int i = 0; i < length1; i++) {
			Element te1 = es1.get(i);
			Element te2 = es2.get(i);
			float sim = compareElement(te1, te2, Level + 1);
			sum += Lp[i] * sim;
		}
		return sum;
	}
}
