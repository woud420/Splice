import ga.Population;


public class PopulationTester {
	public static void main(String[] args) {
		Population pop = new Population(100, new TestChromosomeFactory());
		pop.initializePopulation();
		pop.sort();
		System.out.println(pop.getChromosomes());
	}
}
