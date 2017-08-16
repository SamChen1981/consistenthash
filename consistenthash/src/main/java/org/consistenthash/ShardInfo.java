package org.consistenthash;
import javax.annotation.concurrent.ThreadSafe;

/**
 * Basic spec of shard info. Implementor should be threadsafe.
 *
 * @author wangyankai
 */
@ThreadSafe
public interface ShardInfo {
    int getWeight();

    String getName();
}