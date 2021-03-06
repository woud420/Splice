/*
 * Copyright (C) 2012 Igor de Almeida
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga.stopConditions;

import splice.ga.GeneticAlgorithmStopCondition;

/**
 * Stops the genetic algorithm when after n-generations no evolution is achieved
 * shouldn't used with non-elitist allocators as the values may change so it
 * will come to an infinite loop. This condition considers evolution the
 * increase in the population's best fitness
 * 
 * @author igor
 * 
 */
public class Convergence extends GeneticAlgorithmStopCondition {
	private int maxGenerations;
	private double refFitness = 0;

	private double bestFitness;
	private int generations = 0;

	public Convergence(int maxGenerations) {
		this.maxGenerations = maxGenerations;
	}

	/**
	 * like the default constructor, but it will not stop if the minimum fitness
	 * has not been achieved
	 * 
	 * @param maxGenerations how many generations the GA will stop after the minimum fitness has been reached
	 * @param refFitness average fitness this condition will expect to stop the GA's execution
	 */
	public Convergence(int maxGenerations, double refFitness) {
		this.maxGenerations = maxGenerations;
		this.refFitness = refFitness;
	}

	@Override
	public boolean stop(int generation) {
		double fitness = getProblemType().isMaximization() ?
				getPopulation().getMaximum().getFitness() : 
				getPopulation().getMinimum().getFitness();

		if (fitness == bestFitness)
			generations++;
		if (fitness != bestFitness) {
			bestFitness = fitness;
			generations = 0;
		}

		return generations >= maxGenerations
				& (getProblemType().isMaximization() ?
						bestFitness >= refFitness :
						bestFitness <= refFitness
				);
	}

    @Override
    public boolean isCommonUsage() {
        return false;
    }
}
