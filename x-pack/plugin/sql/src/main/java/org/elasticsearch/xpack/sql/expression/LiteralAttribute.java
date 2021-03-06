/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.xpack.sql.expression;

import org.elasticsearch.xpack.sql.expression.gen.pipeline.Pipe;
import org.elasticsearch.xpack.sql.tree.NodeInfo;
import org.elasticsearch.xpack.sql.tree.Source;
import org.elasticsearch.xpack.sql.type.DataType;

public class LiteralAttribute extends TypedAttribute {

    private final Literal literal;

    public LiteralAttribute(Source source, String name, DataType dataType, String qualifier, Nullability nullability, ExpressionId id,
                            boolean synthetic, Literal literal) {
        super(source, name, dataType, qualifier, nullability, id, synthetic);
        this.literal = literal;
    }

    @Override
    protected NodeInfo<LiteralAttribute> info() {
        return NodeInfo.create(this, LiteralAttribute::new,
                name(), dataType(), qualifier(), nullable(), id(), synthetic(), literal);
    }

    @Override
    protected LiteralAttribute clone(Source source, String name, DataType dataType, String qualifier, Nullability nullability,
                                     ExpressionId id, boolean synthetic) {
        return new LiteralAttribute(source, name, dataType, qualifier, nullability, id, synthetic, literal);
    }

    @Override
    protected String label() {
        return "c";
    }

    @Override
    public Pipe asPipe() {
        return literal.asPipe();
    }
    
    @Override
    public Object fold() {
        return literal.fold();
    }
}
