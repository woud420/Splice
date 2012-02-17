package ga.parallel;

import ga.Population;

public class ParallelPopulation extends Population {
	private int nThreads;

	public ParallelPopulation(int numberThreads) {
		nThreads = numberThreads;
	}

	@Override
	public void calculateFitnessSum() throws Exception {
		AtomicDouble sum = new AtomicDouble(0);
		int i, step, begin;
		step = getSize() / nThreads;
		Thread[] worker = new Thread[nThreads];
		
		for (i = 0, begin = 0; i < nThreads; i++, begin += step) {
			worker[i] = new CalculateFitnessWorker(this, begin, begin+step, sum);
			worker[i].start();
		}
		
		for (i = 0; i < nThreads; i++) {
			worker[i].join();
		}
		
		fitnessAverage = sum.getValue() / getSize();
		/*
		CalculateFitnessWorker t1,t2;
		t1 = new CalculateFitnessWorker(this, 0, getSize() / 2);
		t2 = new CalculateFitnessWorker(this, getSize() / 2, getSize());
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

		fitnessAverage = (t1.getSum() + t2.getSum())  / getSize();
		*/
	}
}
