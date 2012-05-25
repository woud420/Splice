/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package splice.ga.stopConditions;

import splice.ga.Population;
import splice.ga.StopCondition;

public class MinimumBestFitness implements StopCondition {
	private double minimum;
	private Population population;

	public MinimumBestFitness(double minimum) {
		this.minimum = minimum;
	}
	
	@Override
	public boolean stop(int generation) {
		return population.getMaximum().getFitness() >= minimum;
	}

	@Override
	public void setPopulation(Population population) {
		this.population = population;
	}

	@Override
	public Population getPopulation() {
		return population;
	}
}