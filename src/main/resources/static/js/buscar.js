document.getElementById('pesquisar').addEventListener('click', function () {
    // Captura os valores selecionados no formulário
    const searchType = document.querySelector('input[name="searchType"]:checked').value;
    const searchValue = document.getElementById('nome').value;

    // Validação: Verifica se o campo de busca está vazio
    if (!searchValue.trim()) {
        alert("Por favor, insira um valor para buscar.");
        return; // Interrompe o processo se o campo estiver vazio
    }

    // Realiza a requisição ao back-end
    fetch(`/buscar?tipo=${searchType}&valor=${searchValue}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Erro na busca: " + response.statusText);
        }
        return response.json();
    })
    .then(data => {
        const resultTable = document.getElementById('resultTable').querySelector('tbody');
        resultTable.innerHTML = ''; // Limpa resultados anteriores

        data.forEach(item => {
            const row = resultTable.insertRow();
            row.insertCell(0).textContent = item.id;
            row.insertCell(1).textContent = item.nome || item.titulo; // Cliente ou Livro
            row.insertCell(2).textContent = item.telefone || item.autor; // Cliente ou Livro
        });
    })
    .catch(error => {
        console.error('Erro:', error);
        alert("Ocorreu um erro ao buscar os dados. Tente novamente.");
    });
});