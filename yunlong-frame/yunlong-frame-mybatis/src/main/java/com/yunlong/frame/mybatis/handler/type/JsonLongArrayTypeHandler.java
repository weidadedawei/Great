package com.yunlong.frame.mybatis.handler.type;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import lombok.SneakyThrows;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义类型转换，Mybatis符串,Long数组互转（ Long[] <-> 1,2,3 ）
 * <p>
 * MappedJdbcTypes 数据库中的数据类型 MappedTypes java中的的数据类型
 *
 * @author david
 * @date 2023-1-16
 */
@MappedTypes(value = { Long[].class })
@MappedJdbcTypes(value = JdbcType.VARCHAR)
public class JsonLongArrayTypeHandler extends BaseTypeHandler<Long[]> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Long[] parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, ArrayUtil.join(parameter, StrUtil.COMMA));
	}

	@Override
	@SneakyThrows
	public Long[] getNullableResult(ResultSet rs, String columnName) {
		String reString = rs.getString(columnName);
		return Convert.toLongArray(reString);
	}

	@Override
	@SneakyThrows
	public Long[] getNullableResult(ResultSet rs, int columnIndex) {
		String reString = rs.getString(columnIndex);
		return Convert.toLongArray(reString);
	}

	@Override
	@SneakyThrows
	public Long[] getNullableResult(CallableStatement cs, int columnIndex) {
		String reString = cs.getString(columnIndex);
		return Convert.toLongArray(reString);
	}

}
