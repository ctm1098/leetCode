package tonterias;

public class Main1 {
	
	static class NodeList {
		private int val;
		private NodeList next;
		
		public NodeList(int val, NodeList next) {
			this.val = val;
			this.next = next;
		}
		
		public void print() {
			for(NodeList node = this; node != null; node = node.next)
				System.out.println(node.val);
		}
		
		public NodeList reverse() {
			NodeList prevHead = this, head = this;
			if (prevHead != null) {
				NodeList node = head.next, aux;
				while (node != null) {
					aux = node.next;
					node.next = head;
					head = node;
					node = aux;
					prevHead.next = aux;
				}
			}
			return head;
		}
	}

	public static void main(String[] args) {
		
		NodeList list = new NodeList(1,new NodeList(2, new NodeList(3, new NodeList(4, new NodeList(5, null)))));
		list.print();
		System.out.println();
		NodeList reversed = list.reverse();
		reversed.print();

	}

}
