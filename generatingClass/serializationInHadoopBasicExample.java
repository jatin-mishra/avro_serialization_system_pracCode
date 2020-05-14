import org.apache.hadoop.io.*;
import java.io.*;


public class serializationInHadoopBasicExample{
	public byte[] serialize() throws Exception{

		// serialing integer
		Intwritable one = new Intwritable(1);

		ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
		DataOutputStream  data = new DataOutputStream(byteOutput);

		one.write(data);
		byte[] array = byteOutput.toByteArray();

		byteOutput.close();
		return (array)
	}


	public void deserialize(byte[] array) throws Exception{

		IntWritable one = new IntWritable();

		ByteArrayInputStream byteArray = new ByteArrayInputStream(array);
		DataInputStream data = new DataInputStream(byteArray);

		one.readField(data);
		byteArray.close();

		System.out.println(one.get());

	}


	public static void main(String[] args) throws Exception{
		serializationInHadoopBasicExample obj = new serializationInHadoopBasicExample();
		obj.deserialize(obj.serialize());
	}
}