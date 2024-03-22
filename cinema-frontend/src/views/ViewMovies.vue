<template>
  <main>
    <Navbar />
      <div>
        <h1>Filmid</h1>
        <div v-if="movies.length === 0">
          <p>Filme pole saadaval</p>
        </div>
        <div v-else>
          <div v-for="(scheduleItem, index) in schedule" :key="index" class="movie-card">
            <h2>{{ getMovieById(scheduleItem.movieId).name }}</h2>
            <p><strong>Žanr:</strong> {{ convertGenre(getMovieById(scheduleItem.movieId).genre) }}</p>
            <p><strong>Keel:</strong> {{ convertLanguage(getMovieById(scheduleItem.movieId).language) }}</p>
            <p><strong>Vanusepiirang:</strong> {{ convertRestriction(getMovieById(scheduleItem.movieId).ageRestriction) }}</p>

            <div>
              <h3>Aeg:</h3>
              <p>{{ convertDay(scheduleItem.weekDay) }} at {{ convertTime(scheduleItem.startTime) }}</p>
            </div>
          </div>
        </div>
      </div>
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
            movies: [],
            schedule: [],
            selectedAgeRestriction: "",
            selectedLanguage: "",
            selectedStartTime: "",
        }
    },
    computed: {
      // Filtered movies based on selected filters
      filteredMovies() {
        let filtered = this.movies;
        if (this.selectedAgeRestriction) {
          filtered = filtered.filter(movie => movie.ageRestriction === this.selectedAgeRestriction);
        }
        if (this.selectedLanguage) {
          filtered = filtered.filter(movie => movie.language === this.selectedLanguage);
        }
        if (this.selectedStartTime) {
          filtered = filtered.filter(movie => this.movieHasStartTime(movie.id));
        }
        return filtered;
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
        },
        getSchedule(){
          fetch('http://localhost:9090/schedule')
            .then(res => res.json())
            .then(data => {
                this.schedule = data
                console.log(data)
            })
            .catch(error => {
              console.error("Error fetching movies:", error);
            }); 
        },
        getMovieById(movieId) {
          return this.movies.find(movie => movie.id === movieId);
        },
        convertDay(weekday){
          const days = {
            MONDAY: 'Esmaspäev',
            TUESDAY: 'Teisipäev',
            WEDNESDAY: 'Kolmapäev',
            THURSDAY: 'Neljapäev',
            FRIDAY: 'Reede',
            SATURDAY: 'Laupäev',
            SUNDAY: 'Pühapäev',
          }
          return days[weekday]
        },
        convertTime(starttime){
          const times = {
            TIME_9_00: "9:00",
            TIME_10_00: "10:00",
            TIME_11_00: "11:00",
            TIME_12_00: "12:00",
            TIME_13_00: "13:00",
            TIME_14_00: "14:00",
            TIME_15_00: "15:00",
            TIME_16_00: "16:00",
            TIME_17_00: "17:00",
            TIME_18_00: "18:00",
            TIME_19_00: "19:00",
            
          }
          return times[starttime]
        },
        convertLanguage(language){
          const languages = {
            ESTONIAN: "Eesti",
            ENGLISH: "Inglise",
            RUSSION: "Vene",
            MULTILINGUAL: "Mitmekeelne",
          }
          return languages[language]
        },
        convertRestriction(restriction){
          const restrictions = {
            PEREFILM: "Perefilm",
            ALLA_12: "Alla 12 a. mittesoovitav",
            ALLA_12_KEELATUD: "Alla 12 a. keelatud",
            ALLA_14_KEELATUD: "Alla 14 a. keelatud",
            ALLA_6: "Alla 6 a. mittesoovitav",
            LUBATUD_KÕIGILE: "Lubatud kõigile",
          }
          return restrictions[restriction]
        },
        convertGenre(genre){
          const genres = {
            ACTION: "Märul",
            COMEDY: "Komöödia",
            FAMILY: "Kogupere",
            SCIFI: "Ulme",
            THRILLER: "Põnevik",
            ANIMATION: "Multikas",
            HORROR: "Õudukas",
            DRAMA: "Draama",
            DOCUMENTARY: "Dokumentaal",
          }
          return genres[genre]
        }
      
      

    },

    beforeMount(){
      this.getMovies();
      this.getSchedule();
    },

}

</script>

<style>


.movie-card {
  margin-bottom: 20px;
  padding: 10px;
  border: 1px solid #ccc;
}

.filter-menu {
  margin-bottom: 20px;
}
.filter-section {
  display: inline-block;
  margin-right: 20px;
}

</style>