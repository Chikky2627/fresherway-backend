window.onload = function () {

    loadFakeJobs();

};

async function loadFakeJobs() {

    const response =
        await fetch("/api/jobs/fake");

    const jobs =
        await response.json();

    const table =
        document.getElementById("fakeJobsTable");

    table.innerHTML = "";

    jobs.forEach(job => {

        table.innerHTML += `

        <tr>

            <td>${job.id}</td>

            <td>${job.companyName}</td>

            <td>${job.jobTitle}</td>

            <td>${job.fakeReason}</td>

            <td>

                <button
                    class="delete-btn"
                    onclick="deleteJob(${job.id})">

                    Delete

                </button>

            </td>

        </tr>

        `;

    });

}

async function deleteJob(id){

    const response =
        await fetch("/api/jobs/" + id,{

            method:"DELETE"

        });

    alert(await response.text());

    loadFakeJobs();

}

function logout(){

    localStorage.clear();

    window.location.href="/login.html";

}