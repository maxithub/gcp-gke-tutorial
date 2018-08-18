docker build -t ggt01:v1 .
docker run --rm -p 8080:8080 ggt01:v1
docker login -u maxyuan
docker tag ggt01:v1 maxyuan/ggt01:v1
docker push maxyuan/ggt01:v1

docker build -t gcr.io/gke-tutorial-213702/ggt01:v1 .

docker run -ti --rm -p 8080:8080 gcr.io/gke-tutorial-213702/ggt01:v1

gcloud docker -- push gcr.io/gke-tutorial-213702/ggt01:v1

gcloud container clusters create hello-java-cluster \
  --num-nodes 2 \
  --machine-type n1-standard-1 \
  --zone us-west1-a

kubectl run hello-java \
  --image=gcr.io/gke-tutorial-213702/ggt01:v1 \
  --port=8080

kubectl get deployments

kubectl expose deployment hello-java --type=LoadBalancer

kubectl get services

kubectl scale deployment hello-java --replicas=3

docker build -t gcr.io/gke-tutorial-213702/ggt01:v2 .

gcloud docker -- push gcr.io/gke-tutorial-213702/ggt01:v2

kubectl set image deployment/hello-java \
  hello-java=gcr.io/gke-tutorial-213702/ggt01:v2

kubectl rollout undo deployment/hello-java