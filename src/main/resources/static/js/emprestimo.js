// Função para realizar pesquisa
function realizarPesquisa() {
    const tipoBusca = document.getElementById('search').value;
    const valorBusca = document.getElementById('searchInput').value.trim();

    if (valorBusca === '') {
        alert('Por favor, insira um nome para realizar a pesquisa!');
        return;
    }

    const url = tipoBusca === 'clientes' ? `/cliente?nome=${valorBusca}` : `/livro?titulo=${valorBusca}`;
    console.log('URL gerada:', url);

    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao buscar os dados do servidor.');
            }
            return response.json();
        })
        .then(dados => {
            console.log('Dados recebidos:', dados); // Log para ver os dados
            const tabela = tipoBusca === 'clientes' ? document.getElementById('clienteTabela') : document.getElementById('livroTabela');
            tabela.innerHTML = ''; // Limpa a tabela

            dados.forEach(item => {
                const linha = `
                    <tr>
                        <td>${item.id}</td>
                        <td>${tipoBusca === 'clientes' ? item.nome : item.titulo}</td>
                        <td><button type="button" onclick="${tipoBusca === 'clientes' ? `selecionarCliente(${item.id})` : `selecionarLivro(${item.id})`}">Selecionar</button></td>
                    </tr>
                `;
                tabela.innerHTML += linha;
            });
        })
        .catch(error => {
            console.error('Erro ao buscar os dados:', error);
            alert('Não foi possível realizar a pesquisa. Verifique sua conexão.');
        });
}

// Funções para seleção de cliente e livro
function selecionarCliente(id) {
    document.getElementById('idCliente').value = id;
}

function selecionarLivro(id) {
    document.getElementById('idLivro').value = id;
}

// Função para registrar empréstimo
async function registrarEmprestimo(event) {
    event.preventDefault();

    const clienteId = document.getElementById('idCliente').value;
    const livroId = document.getElementById('idLivro').value;
    const dataEmprestimo = document.getElementById('dataEmprestimo').value;
    const dataDevolucao = document.getElementById('dataDevolucao').value;

    if (!clienteId || !livroId || !dataEmprestimo || !dataDevolucao) {
        alert('Por favor, preencha todos os campos!');
        return;
    }

    const emprestimo = {
        cliente: { id: clienteId },
        livro: { id: livroId },
        dataEmprestimo: dataEmprestimo,
        dataDevolucao: dataDevolucao
    };

    try {
        const response = await fetch('/emprestimo', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(emprestimo)
        });

        if (response.ok) {
            alert('Empréstimo cadastrado com sucesso!');
            limparCampos();
        } else {
            const error = await response.json();
            alert('Erro ao registrar empréstimo: ' + (error.message || 'Erro desconhecido.'));
        }
    } catch (error) {
        console.error('Erro:', error);
        alert('Erro ao conectar com o servidor.');
    }
}

// Função para limpar os campos do formulário
function limparCampos() {
    document.getElementById('form-emprestimo').reset();
}