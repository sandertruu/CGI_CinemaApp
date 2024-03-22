<template>
    <main>
        <section class="movies">
           
            <ul>
                <div class="movie" v-for="movie in movies" :key="movie.id">
                    <div class="moviename"> {{ movie.name }} </div> <br />
                    <a class="singlepost">
                        <span class="body"> {{ movie.weekday }}</span> <br />
                    </a>
                </div>
            </ul>
        </section>
    </main>
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
            .then(res => res.json)
            .then(data => {
                this.movies = data
                console.log(data)
            })
        },
        getMoviesByWeekDay(weekday){
            fetch(`http://localhost:9090/movies-by-weekday/${weekday}`)
            .then(res => res.json)
            .then(data => {
                this.movies = data
                console.log(data)
            })
        }
    }
}

</script>
