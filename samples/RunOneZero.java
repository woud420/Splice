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

import splice.ga.GeneticAlgorithm;
import splice.ga.allocators.ElitistAllocator;
import splice.ga.selectors.MinimizeTournamentSelector;
import splice.stopCondition.Iterations;

public class RunOneZero {
	public static void main(String[] args) throws Exception {
		GeneticAlgorithm ga = new GeneticAlgorithm(new OneZeroChromosomeFactory(255), new ElitistAllocator(0.3), new MinimizeTournamentSelector());
		ga.setStopCondition(new Iterations(100));
		ga.execute();
		
		System.out.println();
		System.out.println(ga.getPopulation().getMaximum());
		System.out.println(ga.getPopulation().getMinimum());
		System.out.println(ga.getPopulation().getChromosomesSet().size());
	}
}
