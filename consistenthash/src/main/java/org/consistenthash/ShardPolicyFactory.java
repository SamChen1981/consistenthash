package org.consistenthash;

import java.util.List;

/**
 * 
 * @author wangyankai
 * 2017年8月16日
 */
public interface ShardPolicyFactory extends Provider {
    <T extends ShardInfo> ShardPolicy<T> createShardPolicy(List<T> shards, Hashing algo);
}