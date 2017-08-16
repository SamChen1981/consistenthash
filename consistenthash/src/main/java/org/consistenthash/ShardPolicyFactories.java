package org.consistenthash;

import java.util.List;

/**
 * 
 * @author wangyankai
 * 2017年8月16日
 */
public class ShardPolicyFactories {
    public static class KetamaHashingFactory implements ShardPolicyFactory {
        @Override
        public <T extends ShardInfo> ShardPolicy<T> createShardPolicy(List<T> shards, Hashing algo) {
            return new KetamaHashing<T>(shards, algo);
        }

        @Override
        public String getName() {
            return "jedis";
        }
    }

    public static class ModShardPolicyFactory implements ShardPolicyFactory {
        @Override
        public <T extends ShardInfo> ShardPolicy<T> createShardPolicy(List<T> shards, Hashing algo) {
            return new ModShardPolicy<T>(shards, algo);
        }

        @Override
        public String getName() {
            return "mod";
        }
    }

}
