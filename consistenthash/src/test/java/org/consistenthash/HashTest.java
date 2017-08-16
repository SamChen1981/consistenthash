package org.consistenthash;

import java.util.Arrays;
import java.util.List;

public class HashTest {

	public static void main(String[] args) {
		
		List<ShardNode> shards = Arrays.asList(
				ShardNode.builder().host("11").port(22).build(),
				ShardNode.builder().host("22").port(22).build(),
				ShardNode.builder().host("33").port(22).build(),
				ShardNode.builder().host("44").port(22).build(),
				ShardNode.builder().host("55").port(22).build(),
				ShardNode.builder().host("66").port(22).build(),
				ShardNode.builder().host("77").port(22).build()
				);
		
		String hashAlgo = "murmurhash";
        Hashing hashing = Providers.locateHashing(hashAlgo);
        if (hashing == null) {
            throw new IllegalArgumentException("hashAlgo '" + hashAlgo + "' not found");
        }
        String shardAlgo = "ketama";
        ShardPolicyFactory shardPolicyFactory = Providers.locateShardPolicyFactory(shardAlgo);
        if (shardPolicyFactory == null) {
            throw new IllegalArgumentException("shardAlgo '" + shardAlgo + "' not found.");
        }
		ShardPolicy<ShardNode> shardPolicy = shardPolicyFactory.createShardPolicy(shards, hashing);
		ShardNode dd = shardPolicy.getShardInfo(SafeEncoder.encode("wwwjdcom11534"));
		System.out.println("look "+ dd +" "+ hashing.hash("wwwjdcom11534"));

	}
}
