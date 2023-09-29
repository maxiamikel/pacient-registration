<template>
    <main>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="text-center">View Patients</h2>

                    <a href="/create" class="btn btn-primary">Add Patient</a>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">NAME</th>
                                <th scope="col">PERS NUMBER</th>
                                <th scope="col">EMAIL</th>
                                <th scope="col">PHONE NUMBER</th>
                                <th scope="col">GENDER</th>
                                <th scope="col">ACTION</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="patient in patients" :key="patient.id">
                                <th scope="row">{{patient.id}}</th>
                                <td>{{patient.name}}</td>
                                <td>{{patient.personalNumber}}</td>
                                <td>{{patient.email}}</td>
                                <td>{{patient.telephone}}</td>
                                <td>{{patient.gender}}</td>
                                <td>
                                    <a :href="`/edit/${patient.id}`" class="btn btn-primary">Edit</a>
                                    <button class="btn btn-danger mx-2" @click="$event => deletePatient(patient.id)">Delete</button>
                                </td>
                                <td>{{}}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </main>
    
</template>

<script>
export default{
    name:'Home',
    components:{

    },
    data(){
        return{
            patients:[]
        }
    },
    methods:{
        /*async getPatients(){
            const res = await fetch('http://127.0.0.1:8080/patients/patients');
            const data = await res.json();
            
            console.log(data);
        }*/

        getPatients(){
            fetch('http://127.0.0.1:8080/patients/patients')
            .then(res => res.json())
            .then(data => {
                this.patients = data;

                console.log(data);
            })
        },

        deletePatient(id){
            fetch(`http://localhost:8080/patients/delete/${id}`, {
                method: 'DELETE'
            })
            .then(data => {
                this.getPatients();

                console.log(data);
            })
        }

    },
    mounted (){
        this.getPatients()
    }
}
</script>

<style scoped>

</style>
