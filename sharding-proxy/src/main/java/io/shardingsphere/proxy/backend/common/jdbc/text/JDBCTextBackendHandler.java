/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.proxy.backend.common.jdbc.text;

import io.shardingsphere.proxy.backend.common.jdbc.JDBCBackendHandler;
import io.shardingsphere.proxy.backend.common.jdbc.execute.JDBCExecuteEngineFactory;
import io.shardingsphere.proxy.transport.common.packet.DatabasePacket;
import io.shardingsphere.proxy.transport.mysql.constant.ColumnType;
import io.shardingsphere.proxy.transport.mysql.packet.command.text.query.TextResultSetRowPacket;

import java.util.List;

/**
 * Text protocol backend handler via JDBC to connect databases.
 *
 * @author zhangliang
 * @author panjuan
 * @author zhaojun
 */
public final class JDBCTextBackendHandler extends JDBCBackendHandler {
   
    public JDBCTextBackendHandler(final String sql) {
        super(sql, JDBCExecuteEngineFactory.createTextProtocolInstance());
    }
    
    @Override
    protected DatabasePacket newDatabasePacket(final int sequenceId, final List<Object> data, final int columnCount, final List<ColumnType> columnTypes) {
        return new TextResultSetRowPacket(sequenceId, data);
    }
}
