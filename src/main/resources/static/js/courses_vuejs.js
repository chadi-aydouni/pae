
// La requête en tant que telle avec un ID qu'on récupère, puis modification de reponseData avec les données récupérées grâce à l'API.
var requestData = new Vue({
    el: '#requestData',
    data: {
        id : ""
    },
    methods: {
        getCourse: function () {
            url = "http://localhost:8080/api/courses/"
                + requestData.id;
            console.log("Appel Rest: " + url);
            axios.get(url)
                .then(function (response) {
                    data = response.data;
                    responseData.id = data.id;
                    responseData.title = data.title;
                    responseData.credits = data.credits;
                })
                .catch(function (error) {
                    alert("Erreur appel REST");
                });
        }
    }
});

var responseData = new Vue({
    el: '#responseData',
    data: {
        id : "",
        title : "",
        credits : 0
    }
});