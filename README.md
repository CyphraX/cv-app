# CV-App

Personal CV/Portfolio website running on a self-hosted Kubernetes cluster.

## Architecture

- **Frontend**: SvelteKit with static adapter, served by Nginx
- **Backend**: Kotlin Spring Boot REST API
- **Infrastructure**: K3s on Raspberry Pi with Traefik Ingress

## Local Development

### Backend

```bash
cd backend
./gradlew bootRun
```

API available at http://localhost:8080

### Frontend

```bash
cd frontend
bun install
bun run dev
```

Frontend available at http://localhost:5173

## Deployment

Images are automatically built and pushed to GitHub Container Registry on push to `main`.

### Manual Deployment

```bash
# Apply all Kubernetes manifests
kubectl apply -f k8s/

# Check status
kubectl get pods -n cv-app
kubectl get ingress -n cv-app
```

### First-time Setup

1. Create GHCR pull secret:
   ```bash
   kubectl create secret docker-registry ghcr-secret \
     --namespace cv-app \
     --docker-server=ghcr.io \
     --docker-username=YOUR_GITHUB_USER \
     --docker-password=YOUR_GITHUB_TOKEN
   ```

2. Update image references in `k8s/*.yaml` with your GitHub username

3. Apply manifests

## URLs

- Production: https://cv.philippsaal.com
- API Health: https://cv.philippsaal.com/api/health
