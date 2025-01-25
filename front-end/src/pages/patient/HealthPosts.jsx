import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "@/components/ui/table";
import PaginationComponent from "@/components/pagination";
import { useState } from "react";
import { healthPost } from "@/data/tableHealthPosts";


const healthPosts = () => {
    const ITEMS_PER_PAGE = 10;
    const [currentPage, setCurrentPage] = useState(1);

    // Usando o array importado diretamente
    const startIndex = (currentPage - 1) * ITEMS_PER_PAGE;
    const visibleItems = healthPost.slice(startIndex, startIndex + ITEMS_PER_PAGE);
    const totalPages = Math.ceil(healthPost.length / ITEMS_PER_PAGE);




    return (
        <div>
            <div className="min-h-[100vh] flex-1 rounded-xl bg-muted/50 md:min-h-min">
                 
                    <>
                        <Table>
                            <TableHeader>
                                <TableRow>
                                    <TableHead>Nome</TableHead>
                                    <TableHead>Horário Funcionamento</TableHead>
                                    <TableHead>Endereço</TableHead>
                                </TableRow>
                            </TableHeader>

                            <TableBody>
                                {visibleItems.map((item, index) => (
                                    <TableRow key={index}>
                                        <TableCell className="font-medium">{item.nome}</TableCell>
                                        <TableCell>{item.horarioFuncionamento}</TableCell>
                                        <TableCell>{item.endereco}</TableCell>
                                        
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                        
                        <PaginationComponent
                            currentPage={currentPage}
                            totalPages={totalPages}
                            onPageChange={setCurrentPage}
                        />
                    </>
            </div>
        </div>
    );
};

export default healthPosts;