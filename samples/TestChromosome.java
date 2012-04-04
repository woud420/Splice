
import splice.ga.BasicChromosome;

public class TestChromosome extends BasicChromosome {
	long a, b;

	public TestChromosome(long a, long b) {
		this.a = a;
		this.b = b;
	}
	
	public TestChromosome() {
		this(0,0);
	}

	public TestChromosome(int a, int b) {
		this((long) a, (long) b);
	}

	@Override
	protected double fitness() {
		double dist = Math.abs(Math.abs(a) - Math.abs(b));
		return 1 / (dist + 1);
	}

	@Override
	public BasicChromosome crossover(BasicChromosome chromossome) {
		TestChromosome otherGenome = (TestChromosome) chromossome;
		TestChromosome newGenome = new TestChromosome();

		long r1, r2, l1, l2;

		r1 = a >> 32;
		l1 = a ^ (r1 << 32);
		r2 = otherGenome.a >> 32;
		l2 = otherGenome.a ^ (r2 << 32);

		newGenome.a = l1 ^ r2;

		r1 = b >> 32;
		l1 = b ^ (r1 << 32);
		r2 = otherGenome.b >> 32;
		l2 = otherGenome.b ^ (r2 << 32);

		newGenome.b = l2 ^ r1;

		return newGenome;
	}

	@Override
	public void mutate() {
		if (getRandom().nextBoolean())
			if (getRandom().nextBoolean())
				a += 1;
			else
				a -= 1;
		else if (getRandom().nextBoolean())
			b += 1;
		else
			b -= 1;
	}

	@Override
	public String toString() {
		return "a = " + a + "\nb = " + b + "\nfitness = " + fitness();
	}
}
