# Gabriel Felipe Soares Blog

My Personal Blog

You can (access here)[https://gabrielfs7.github.io].

## Instruction in case you want to run locally

- You need docker.

### Start Docker container

```
docker-compose up --force-recreate
```

### Regenerate container if needed

```
docker exec -it gabriel_blog_app bash

bundle install
jekyll build
```