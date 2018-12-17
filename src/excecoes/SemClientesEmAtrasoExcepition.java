package excecoes;

public class SemClientesEmAtrasoExcepition extends Exception {
	public SemClientesEmAtrasoExcepition() {
		super("Sem clientes em atraso");
	}
}
