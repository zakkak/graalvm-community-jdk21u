/*
 * Copyright (c) 2023, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package org.graalvm.compiler.truffle.common;

import org.graalvm.compiler.truffle.common.TruffleCompilerRuntime.InlineKind;
import org.graalvm.compiler.truffle.common.TruffleCompilerRuntime.LoopExplosionKind;

/**
 * TODO GR-44222 as soon as the annotation API is available in libgraal this can be moved to the
 * compiler implementation side.
 */
public record PartialEvaluationMethodInfo(
                /**
                 * Queries how loops in {@code method} with constant number of invocations should be
                 * unrolled.
                 */
                LoopExplosionKind loopExplosion,

                /**
                 * Gets an object describing whether and how a method can be inlined based on
                 * Truffle directives during partial evaluation.
                 */
                InlineKind inlineForPartialEvaluation,

                /**
                 * Gets an object describing whether and how a method can be inlined based on
                 * Truffle directives after partial evaluation e.g. during later inlining phases.
                 */
                InlineKind inlineForTruffleBoundary,

                /**
                 * Determines if {@code method} can be inlined by the runtime (independently from
                 * Truffle).
                 */
                boolean isInlineable,

                /**
                 * Determines if {@code method} is annotated by {@code Specialization}.
                 */
                boolean isSpecializationMethod) {

}
