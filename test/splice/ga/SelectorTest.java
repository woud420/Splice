/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga;

import org.junit.Before;
import org.junit.Test;

import splice.ProblemTypeTest;
import splice.RandomComponentTest;

import util.TestSelector;

/**
 * @author igor
 */
public class SelectorTest {
    Selector selector;

    @Before
    public void setUp() {
        selector = new TestSelector();
    }

    @Test
    public void testRandom() {
        RandomComponentTest.doTest(selector);
    }

    @Test
    public void testProblemType() {
        ProblemTypeTest.doTest(selector);
    }
}