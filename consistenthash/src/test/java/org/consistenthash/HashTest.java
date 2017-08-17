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
		
		List<MyShard> myShards = Arrays.asList(
				new MyShard("shard1"),
				new MyShard("shard2"),
				new MyShard("shard3")
				
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
		ShardPolicy<MyShard> shardPolicy = shardPolicyFactory.createShardPolicy(myShards, hashing);
		MyShard shard = shardPolicy.getShardInfo(SafeEncoder.encode("wwwjdcom"));
		System.out.println("look "+ shard.getName() +" "+ hashing.hash("wwwjdcom"));

	}
	
}

class MyShard implements ShardInfo {

	private String name;
	
	public MyShard(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public int getWeight() {
		return 1;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
}
