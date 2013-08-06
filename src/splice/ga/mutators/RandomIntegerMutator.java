/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga.mutators;

import splice.RandomUtil;
import splice.ga.Mutator;
import splice.ga.genes.IntegerListGene;

/**
 * @author igor
 */
public class RandomIntegerMutator implements Mutator<IntegerListGene> {
    private int max;

    public RandomIntegerMutator(int max) {
        this.max = max;
    }

    public RandomIntegerMutator() {
        max = Integer.MAX_VALUE;
    }

    @Override
    public void mutate(IntegerListGene gene) {
        gene.set(RandomUtil.getRandom().nextInt(gene.getSize()), RandomUtil.getRandom().nextInt(max));
    }
}