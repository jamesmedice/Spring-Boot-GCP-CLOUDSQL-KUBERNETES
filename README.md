# Spring vs GCP


generate api key 
gcloud auth application-default login


Credentials saved to file: [/tmp/tmp.dG9nLliG41/application_default_credentials.json]



cluster info :  gcloud container clusters get-credentials  spring-boot-cluster  --zone europe-north1-a

gcloud config set project [PROJECT_ID]

connect mysql : mysql -h mysql -u your_user -D your_database -pyour_password



create secret : 

kubectl get secret mysqlcontainer -o yaml
apiVersion: v1
data:
  password: dHBtMTIzNA==
  username: cm9vdA==
kind: Secret
metadata:
  annotations:
    kubectl.kubernetes.io/last-applied-configuration: |
      {"apiVersion":"v1","data":{"password":"dHBtMTIzNA==","username":"cm9vdA=="},"kind":"Secret","metadata":{"annotations":{},"creationTimestamp":"2019-10-22T11:58:08Z","name":"mysqlcontainer","namespace":"default","resourceVersion":"3278002","selfLink":"/api/v1/namespaces/default/secrets/mysqlcontainer","uid":"36f690da-f4c3-11e9-879e-42010aa6007f"},"type":"Opaque"}
  creationTimestamp: "2019-10-22T11:58:08Z"
  name: mysqlcontainer
  namespace: default
  resourceVersion: "3278007"
  selfLink: /api/v1/namespaces/default/secrets/mysqlcontainer
  uid: 36f690da-f4c3-11e9-879e-42010aa6007f
type: Opaque


 # DOCKER 
 
docker build -t  gcr.io/[poject]/app-gke:v1

docker-credential-gcr configure-docker

docker tag app-gke gcr.io/[poject]/app-gke

docker push gcr.io/[poject]/app-gke


gcloud container clusters create kuben --zone us-central1-f \
--machine-type=n1-standard-2  --enable-autorepair \
--enable-autoscaling --max-nodes=10 --min-nodes=1

gcloud container clusters list
