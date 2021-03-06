/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package util;

import splice.ga.GeneticAlgorithmStopCondition;

/**
 * @author igor
 */
public class MockGeneticAlgorithmStopCondition extends GeneticAlgorithmStopCondition {
    private final boolean willStop;

    public MockGeneticAlgorithmStopCondition(boolean willStop) {
        this.willStop = willStop;
    }

    @Override
    public boolean stop(int generation) {
        return willStop;
    }

    @Override
    public boolean isCommonUsage() {
        return false;
    }
}
