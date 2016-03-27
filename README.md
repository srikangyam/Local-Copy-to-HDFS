Build the jar using:
mvn clean -Dmaven.test.skip install

Run the jar to transfer the required file via:
hadoop jar target/copyFromLocal-0.0.1-SNAPSHOT.jar com.skangyam.hadoop.copyFromLocal.copyToHDFS ~/workspace/srcFile.txt hdfs://localhost:8020/user/skangyam/input/targetFile.txt

Run the test to confirm the if the file has been copied correctly via:
mvn clean -Dtest=AppTest -DsearchKey="/user/skangyam/input/targetFile.txt" test

