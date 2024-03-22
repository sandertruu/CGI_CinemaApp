<template>
    <div>
      <h1>Movies</h1>
      <div v-if="movies.length === 0">
        <p>No movies available</p>
      </div>
      <div v-else>
        <div v-for="(movie, index) in movies" :key="index" class="movie-card">
          <h2>{{ movie.name }}</h2>
          <p><strong>Genre:</strong> {{ movie.genre }}</p>
          <p><strong>Language:</strong> {{ movie.language }}</p>
          <p><strong>Age Restriction:</strong> {{ movie.ageRestriction }}</p>
        </div>
      </div>
    </div>
  </template>

<script>

import NavBar from '../components/NavBar.vue'

export default {
    name: 'ViewMovies',
    components: {
        NavBar
    },
    data(){
        return {
            movies: []
        }
    },

    methods: {
        getMovies(){
            fetch('http://localhost:9090/allmovies')
            .then(res => res.json())
            .then(data => {
                this.movies = data
                console.log(data)
            })
            .catch(error => {
              console.error("Error fetching movies:", error);
            });  
        },
        getMoviesByWeekDay(weekday){
            fetch(`http://localhost:9090/movies-by-weekday/${weekday}`)
            .then(res => res.json)
            .then(data => {
                this.movies = data
                console.log(data)
            })
        }
    },

    beforeMount(){
      this.getMovies();
    }
}

</script>

<style>


.movie-card {
  margin-bottom: 20px;
  padding: 10px;
  border: 1px solid #ccc;
}

</style>