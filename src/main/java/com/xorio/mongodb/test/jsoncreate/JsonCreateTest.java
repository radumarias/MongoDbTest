package com.xorio.mongodb.test.jsoncreate;

import static com.xorio.mongodb.test.util.JsonUtils.$;
import static com.xorio.mongodb.test.util.JsonUtils.$arr;

/**
 * User: radu
 * Date: 9/27/14
 * Time: 2:28 PM
 */
public class JsonCreateTest {

	public static void main(String[] args) {
		/*

		{ "x" : 1}

		*/
		System.out.println(
				$("x", 1)
		);


		/*

		{
		   "x":{
		      "$ne":3
		   }
		}

	   */
		System.out.println(
				$(
						"x", $(
								"$ne", 3
						)
				)
		);


		/*

		{
		   "x":{
		      "y":{
		         "z1":1,
		         "z2":2
		      },
		      "array":[
		         {
		            "a1":1
		         },
		         1
		      ]
		   }
		}

		*/
		System.out.println(
				$(
						"x", $(
								$("y", $(
												$("z1", 1),
												$("z2", 2)
										)
								),
								$arr("array",
										$("a1", 1),
										1
								)
						)
				)
		);
	}
}
