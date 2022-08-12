window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }

    axios.get("/admin/statisticsList").then(res => {
        const posts = res.data
        const postList = [];
        posts.forEach(async (history) => {
           
            postList.push(
                `<tr class="postDetail">
                    <td class="postId">${history.hno}</td>
                    <td class="postBno">${history.bno}</td>
                    <td class="postEmail">${history.email}</td>
                    <td class="postisLock">${history.hbool}</td>
                    <td class="postRegDate">${history.hreg_date}</td>
                    <td class="postDno">${history.dno}</td>
                    <td class="postTno">${history.tno}</td>
                </tr>`)

        })
        document.querySelector("tbody").innerHTML = postList.join('')
    })
    
}, false);
