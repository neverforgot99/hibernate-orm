/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.sql.ast.produce.sqm.internal;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.query.sqm.tree.expression.SqmParameter;
import org.hibernate.sql.ast.produce.sqm.spi.SqmDeleteInterpretation;
import org.hibernate.sql.ast.tree.delete.DeleteStatement;
import org.hibernate.sql.exec.spi.JdbcParameter;

/**
 * @author Steve Ebersole
 */
public class SqmDeleteInterpretationImpl implements SqmDeleteInterpretation {
	private final List<DeleteStatement> sqlDeletes;
	private final Set<String> affectedTables;
	private final Map<SqmParameter, List<JdbcParameter>> jdbcParamXref;

	public SqmDeleteInterpretationImpl(
			List<DeleteStatement> sqlDeletes,
			Set<String> affectedTables,
			Map<SqmParameter, List<JdbcParameter>> jdbcParamXref) {
		this.sqlDeletes = sqlDeletes;
		this.affectedTables = affectedTables;
		this.jdbcParamXref = jdbcParamXref;
	}

	@Override
	public List<DeleteStatement> getSqlDeletes() {
		return sqlDeletes;
	}

	@Override
	public Set<String> getAffectedTableNames() {
		return affectedTables;
	}

	@Override
	public Map<SqmParameter, List<JdbcParameter>> getJdbcParamsBySqmParam() {
		return jdbcParamXref;
	}
}
