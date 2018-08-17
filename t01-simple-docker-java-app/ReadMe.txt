docker build -t ggt01:v1 .
docker run --rm -p 8080:8080 ggt01:v1
docker login -u maxyuan
docker tag ggt01:v1 maxyuan/ggt01:v1
docker push maxyuan/ggt01:v1