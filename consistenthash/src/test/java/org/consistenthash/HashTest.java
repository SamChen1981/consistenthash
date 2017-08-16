package org.consistenthash;

import java.nio.charset.Charset;
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
		KetamaHashing<ShardNode> kahsh = new KetamaHashing<ShardNode>(shards, new MurmurHash());
//		int i = 0;
//		for ( Entry<Long, AtomicReference<ShardNode>> n : kahsh.getNodes().entrySet()) {
//			ShardNode v = n.getValue().get();
//			if (v.getHost().equals("22") || v.getHost().equals("33"))
//			System.err.println(n.getKey() +" "+ v +" "+ (++i));
//		}
		Charset charset = Charset.forName("utf-8");
		ShardNode dd = kahsh.getShardInfo("wwwjdcom11534".getBytes(charset));
		System.out.println("look "+ dd +" "+ new MurmurHash().hash("wwwjdcom11534"));

	}
}
