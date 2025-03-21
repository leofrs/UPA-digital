import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "@/components/ui/table";
import PaginationComponent from "@/components/pagination";
import { useState } from "react";
import { Outlet, useLocation } from "react-router-dom";
import { allDoctors } from "@/data/tableAllDoctors";

const AllPatient = () => {
    const ITEMS_PER_PAGE = 10;
    const [currentPage, setCurrentPage] = useState(1);

    // Usando o array importado diretamente
    const startIndex = (currentPage - 1) * ITEMS_PER_PAGE;
    const visibleItems = allDoctors.slice(startIndex, startIndex + ITEMS_PER_PAGE);
    const totalPages = Math.ceil(allDoctors.length / ITEMS_PER_PAGE);

    const location = useLocation();


    return (
        <div>
            <div className="min-h-[100vh] flex-1 rounded-xl bg-muted/50 md:min-h-min">
               
                    <>
                        <Table>
                            <TableHeader>
                                <TableRow>
                                    <TableHead>Nome</TableHead>
                                    <TableHead>Especialididade</TableHead>
                                    <TableHead>Posto</TableHead>
                                    <TableHead>Contato</TableHead>
                                </TableRow>
                            </TableHeader>

                            <TableBody>
                                {visibleItems.map((item, index) => (
                                    <>
                                    <TableRow key={index}>
                                        <TableCell className="font-medium">{item.nome}</TableCell>
                                        <TableCell>{item.especialidade}</TableCell>
                                        <TableCell>{item.posto}</TableCell>
                                        <TableCell>{item.contato}</TableCell>
                                    </TableRow>

                                       
                                    </>
                                    
                                    
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

export default AllPatient;
