/**
 *    Copyright 2009-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.executor.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.ResultHandler;

/**
 * @author Clinton Begin
 */
/**
 * StatementHandler接口，用于处理SQL语句的准备、参数设置、批处理、更新和查询等操作
 */
public interface StatementHandler {

  /**
   * 准备SQL语句
   * @param connection 数据库连接
   * @param transactionTimeout 事务超时时间
   * @return 准备好的Statement对象
   * @throws SQLException SQL异常
   */
  Statement prepare(Connection connection, Integer transactionTimeout)
          throws SQLException;

  /**
   * 设置参数到Statement对象中
   * @param statement Statement对象
   * @throws SQLException SQL异常
   */
  void parameterize(Statement statement)
          throws SQLException;

  /**
   * 批处理操作
   * @param statement Statement对象
   * @throws SQLException SQL异常
   */
  void batch(Statement statement)
          throws SQLException;

  /**
   * 更新操作
   * @param statement Statement对象
   * @return 更新的行数
   * @throws SQLException SQL异常
   */
  int update(Statement statement)
          throws SQLException;

  /**
   * 查询操作
   * @param statement Statement对象
   * @param resultHandler 结果处理器
   * @param <E> 结果类型
   * @return 查询结果列表
   * @throws SQLException SQL异常
   */
  <E> List<E> query(Statement statement, ResultHandler resultHandler)
          throws SQLException;

  /**
   * 查询操作，返回游标
   * @param statement Statement对象
   * @param <E> 结果类型
   * @return 游标对象
   * @throws SQLException SQL异常
   */
  <E> Cursor<E> queryCursor(Statement statement)
          throws SQLException;

  /**
   * 获取BoundSql对象
   * @return BoundSql对象
   */
  BoundSql getBoundSql();

  /**
   * 获取ParameterHandler对象
   * @return ParameterHandler对象
   */
  ParameterHandler getParameterHandler();

}
