/*
 * Copyright © 2010-2012 Philipp Eichhorn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package lombok;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.*;

/**
 * Locking beyond {@code @Synchronized}.
 * 
 * <pre>
 * void methodAnnotatedWithReadLock() {
 *   this.&lt;LOCK_NAME&gt;.readLock().lock();
 *   try {
 * 
 *     // method body
 * 
 *   } finally {
 *     this.&lt;LOCK_NAME&gt;.readLock().unlock();
 *   }
 * }
 * 
 * <pre>
 */
@Target(METHOD)
@Retention(SOURCE)
public @interface ReadLock {
	/**
	 * Name of the lock.
	 * <p>
	 * If no lock with the specified name exists a new {@link java.util.concurrent.locks.ReadWriteLock ReadWriteLock}
	 * will be created, using this name.
	 */
	String value();
}
