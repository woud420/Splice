/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga.allocators;

import splice.ga.PopulationAllocator;


/**
 * Allocate the new population simply replacing the old one
 * @author igor
 *
 */
public class ReplaceAllocator extends PopulationAllocator {
	@Override
	public void allocate() {
		this.setPopulation(getNewPopulation());
	}
	
	@Override
	public boolean complete() {
		return bufferSize() >= getPopulation().getSize();
	}

	@Override
	public void initialize() { }
}
