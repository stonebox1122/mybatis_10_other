package com.stone.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.stone.mybatis.bean.EmpStatus;

/**
 * 1、实现TypeHandler接口，或者继承BaseTypeHandler
 * @author lei.shi445
 *
 */
public class MyEnumEmpStatusTypeHandler implements TypeHandler<EmpStatus>{

	/**
	 * 定义当前数据如何保存到数据库中
	 */
	@Override
	public void setParameter(PreparedStatement ps, int i, EmpStatus parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		ps.setString(i, parameter.getCode().toString());
	}

	@Override
	public EmpStatus getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		//需要根据从数据库中拿到的枚举的状态码返回一个枚举对象
		int code = rs.getInt(columnName);
		System.out.println("从数据库中获取的状态码：" + code);
		EmpStatus empStatus = EmpStatus.getEmpStatusByCode(code);
		return empStatus;
	}

	@Override
	public EmpStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		int code = rs.getInt(columnIndex);
		System.out.println("从数据库中获取的状态码：" + code);
		EmpStatus empStatus = EmpStatus.getEmpStatusByCode(code);
		return empStatus;
	}

	@Override
	public EmpStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		int code = cs.getInt(columnIndex);
		System.out.println("从数据库中获取的状态码：" + code);
		EmpStatus empStatus = EmpStatus.getEmpStatusByCode(code);
		return empStatus;
	}

}
