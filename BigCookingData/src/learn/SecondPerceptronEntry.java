package learn;


public class SecondPerceptronEntry {
	
	private FirstPerceptronEntry fpe = new FirstPerceptronEntry();
	private PerceptronUtility pu = new PerceptronUtility();
	private FirstPerceptron firstPhase = new FirstPerceptron(fpe, pu);
	
	
	public SecondPerceptronEntry(){
		
	}
	
	public SecondPerceptronEntry(FirstPerceptronEntry fpe, PerceptronUtility pu, FirstPerceptron firstPhase) {
		super();
		this.fpe = fpe;
		this.pu = pu;
		this.firstPhase = firstPhase;
	}
	
	
	public FirstPerceptronEntry getFpe() {
		return fpe;
	}
	public void setFpe(FirstPerceptronEntry fpe) {
		this.fpe = fpe;
	}
	public PerceptronUtility getPu() {
		return pu;
	}
	public void setPu(PerceptronUtility pu) {
		this.pu = pu;
	}
	public FirstPerceptron getFirstPhase() {
		return firstPhase;
	}
	public void setFirstPhase(FirstPerceptron firstPhase) {
		this.firstPhase = firstPhase;
	}

	
	
	
}
