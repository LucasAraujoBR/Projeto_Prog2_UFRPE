package partePedidos;

public class testemainPedidos {

	public static void main(String[] args) {

		/* Classes mesas e pedidos funcionando! */

		PedidosCRUD p = new PedidosCRUD();
		/*
		 * Pedidos p1 = new Pedidos(1, "A", 1, 1, false); Pedidos p2 = new Pedidos(1,
		 * "B", 1, 1, false); Pedidos p3 = new Pedidos(1, "C", 1, 1, false);
		 * ControleMesa m = new ControleMesa(); Mesa m1 = new Mesa(4, 8); Mesa m2 = new
		 * Mesa(5, 3); Mesa m3 = new Mesa(6, 2); m.cadrastarMesas(m1);
		 * m.cadrastarMesas(m2); m.cadrastarMesas(m3);
		 * System.out.println(m.listarMesas()); p.cadrastarPedidos(p1);
		 * p.cadrastarPedidos(p2); p.cadrastarPedidos(p3); p.addPedidos(m1, p1);
		 * p.addPedidos(m1, p3); p.addPedidos(m3, p1); p.addPedidos(m2, p2);
		 * System.out.println(p.listarCardapio());
		 * System.out.println("-----------------------------------");
		 * System.out.println(p.listarPedidos());
		 */

		pedCAD pd = new pedCAD("Pizza", 1, 22.5);
		p.cadPED(pd);
		System.out.println(p.listarCadPed());

	}

}
