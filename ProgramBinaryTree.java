import java.util.*;

class BinaryTree {
	public int valor;
	public BinaryTree left;
	public BinaryTree right;
}

class Tree {
	private BinaryTree root;

	public Tree() {
		root = null;
	}

	long soma = 0L;

	public void insert(int value) {
		BinaryTree newTree = new BinaryTree();
		newTree.valor = value;
		newTree.right = null;
		newTree.left = null;

		if (root == null)
			root = newTree;
		else {
			BinaryTree current = root;
			BinaryTree previous;
			while (true) {
				previous = current;
				if (value <= current.valor) {
					current = current.left;
					if (current == null) {
						previous.left = newTree;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						previous.right = newTree;
						return;
					}
				}
			}
		}

	}

	public BinaryTree search(int key) {
		if (root == null)
			return null;
		BinaryTree current = root;
		while (current.valor != key) {
			if (key < current.valor)
				current = current.left;
			else
				current = current.right;
			if (current == null)
				return null;
		}
		return current;
	}

	public void Sum(BinaryTree bt) {
		if (bt != null) {
			soma = soma + bt.valor;
			Sum(bt.right);
		}
	}

}

class BinaryTreeApp {
	private static Scanner read;

	public static void main(String[] args) {
		read = new Scanner(System.in);
		Tree tree = new Tree();
		int option = 0;
		int x;
		System.out.println("Programa Árvore Binária");

		while (option != 3) {
			System.out.println("-----------------------------------");
			System.out.println("1. Inserir");
			System.out.println("2. Soma");
			System.out.println("3. Sair");
			System.out.println("-----------------------------------");

			option = read.nextInt();
			switch (option) {
			case 1: {
				System.out.println("Informe o valor para inserir: ");
				x = read.nextInt();
				tree.insert(x);
				break;
			}
			case 2: {
				System.out.println("Informe o valor a ser procurado e depois somar: ");
				x = read.nextInt();
				BinaryTree current = tree.search(x);
				tree.Sum(current);
				System.out.println("Soma: " + tree.soma);
				break;
			}
			}
		}

	}
}