package ga;

import java.util.ArrayList;

/**
 * This genetic algorithm maximizes the a fitness function 
 * @author igor
 *
 */
public class MaxmizeGeneticAlgorithm extends GeneticAlgorithm {
	public MaxmizeGeneticAlgorithm(ChromosomeFactory factory,
			PopulationAllocator allocator, Selector selector) {
		super(factory, allocator, selector);
	}

	@Override
	protected ArrayList<Chromosome> doGeneneration() {
		ArrayList<Chromosome> newPopulation = new ArrayList<Chromosome>();
		Chromosome a, b, c;

		getPopulation().sort();

		for (int i = 0; i < getPopulationSize(); i++) {
			a = getChromosome();
			b = getChromosome();
			c = a.crossover(b);
			mutate(c);
			newPopulation.add(c);

			if (RandomUtil.getRandom().nextDouble() < getCrossoverRate()) {
				c = b.crossover(a);
				mutate(c);
				newPopulation.add(c);
				i++;
			}
		}

		return newPopulation;
	}

	@Override
	public Chromosome getBest() {
		double fitness = 0;
		Chromosome chromosome = null;
		for (Chromosome g : getPopulation().getChromosomes()) {
			if (g.getFitness() >= fitness) {
				fitness = g.getFitness();
				chromosome = g;
			}
		}
		return chromosome;
	}

	@Override
	public Chromosome getWorst() {
		Chromosome chromosome = getPopulation().getRandom();
		double fitness = chromosome.getFitness();
		for (Chromosome g : getPopulation().getChromosomes()) {
			if (g.getFitness() <= fitness) {
				fitness = g.getFitness();
				chromosome = g;
			}
		}
		return chromosome;
	}

}
