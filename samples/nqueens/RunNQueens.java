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

package nqueens;

import splice.ga.GeneticAlgorithm;
import splice.ga.allocators.ElitistAllocator;
import splice.ga.parallel.ParallelPopulation;
import splice.ga.selectors.TournamentSelector;
import splice.stopCondition.Iterations;

public class RunNQueens {
	public static void main(String[] args) throws Exception {
		GeneticAlgorithm ga = new GeneticAlgorithm(new NQueensChromosomeFactory(8), new ElitistAllocator(0.1), new TournamentSelector(2));
        ga.getProblemType().setMinimization();
        ga.setPopulation(new ParallelPopulation());
		ga.setStopCondition(new Iterations(10000));
        ga.setPopulationSize(100);
		ga.execute();
		
		System.out.println(ga.getPopulation().getMaximum());
        System.out.println(ga.getLastTime());
    }
}
