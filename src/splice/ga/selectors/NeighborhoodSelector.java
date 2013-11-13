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

package splice.ga.selectors;

import splice.RandomUtil;
import splice.ga.BasicChromosome;
import splice.ga.Selector;

public class NeighborhoodSelector extends Selector {
	/**
	 * maximum search distance from current pivot
	 */
	private int maxSearchDistance;
	private int pivot = -1;
	
	public NeighborhoodSelector(int maxDistance) {
		maxSearchDistance = maxDistance;
	}

	@Override
	public void initialize() { }

	@Override
	public void beforeGeneration() { }

	@Override
	public BasicChromosome getChromosome() {
		BasicChromosome c;
		
		if (pivot == -1) {
			pivot = RandomUtil.getRandom().nextInt(getPopulation().getSize());
			c = getPopulation().get(pivot);
		}
		else {
			// if true will select a lesser value
			if (RandomUtil.getRandom().nextBoolean()) {
				 pivot -= RandomUtil.getRandom().nextInt(maxSearchDistance);
				 pivot = (getPopulation().getSize() - pivot) % getPopulation().getSize();
			}
			else {
				pivot += RandomUtil.getRandom().nextInt(maxSearchDistance);
				pivot = pivot % getPopulation().getSize();
			}
			c = getPopulation().get(pivot);
			pivot = -1;
		}
			
		return c;
	}
}
